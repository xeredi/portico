/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.struts2.json;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Deserializes and object from a JSON string
 * </p>
 */
public class JSONReader {
    private static final Object OBJECT_END = new Object();
    private static final Object ARRAY_END = new Object();
    private static final Object COLON = new Object();
    private static final Object COMMA = new Object();
    private static Map<Character, Character> escapes = new HashMap<Character, Character>();

    static {
        escapes.put('"', '"');
        escapes.put('\\', '\\');
        escapes.put('/', '/');
        escapes.put('b', '\b');
        escapes.put('f', '\f');
        escapes.put('n', '\n');
        escapes.put('r', '\r');
        escapes.put('t', '\t');
    }

    private CharacterIterator it;
    private char c;
    private Object token;
    private final StringBuilder buf = new StringBuilder();

    protected char next() {
        c = it.next();

        return c;
    }

    protected void skipWhiteSpace() {
        while (Character.isWhitespace(c)) {
            next();
        }
    }

    public Object read(final String string) throws JSONException {
        it = new StringCharacterIterator(string);
        c = it.first();

        return this.read();
    }

    protected Object read() throws JSONException {
        Object ret;

        skipWhiteSpace();

        if (c == '"') {
            next();
            ret = string('"');
        } else if (c == '\'') {
            next();
            ret = string('\'');
        } else if (c == '[') {
            next();
            ret = array();
        } else if (c == ']') {
            ret = ARRAY_END;
            next();
        } else if (c == ',') {
            ret = COMMA;
            next();
        } else if (c == '{') {
            next();
            ret = object();
        } else if (c == '}') {
            ret = OBJECT_END;
            next();
        } else if (c == ':') {
            ret = COLON;
            next();
        } else if (c == 't' && next() == 'r' && next() == 'u' && next() == 'e') {
            ret = Boolean.TRUE;
            next();
        } else if (c == 'f' && next() == 'a' && next() == 'l' && next() == 's' && next() == 'e') {
            ret = Boolean.FALSE;
            next();
        } else if (c == 'n' && next() == 'u' && next() == 'l' && next() == 'l') {
            ret = null;
            next();
        } else if (Character.isDigit(c) || c == '-') {
            ret = number();
        } else {
            throw buildInvalidInputException();
        }

        if (ret instanceof String) {
            if (((String) ret).isEmpty()) {
                token = null;

                return null;
            }
        }

        token = ret;

        return ret;
    }

    @SuppressWarnings("unchecked")
    protected Map object() throws JSONException {
        final Map ret = new HashMap();
        final Object next = this.read();
        if (next != OBJECT_END) {
            String key = (String) next;
            while (token != OBJECT_END) {
                this.read(); // should be a colon

                if (token != OBJECT_END) {
                    ret.put(key, this.read());

                    if (this.read() == COMMA) {
                        final Object name = this.read();

                        if (name instanceof String) {
                            key = (String) name;
                        } else {
                            throw buildInvalidInputException();
                        }
                    }
                }
            }
        }

        return ret;
    }

    protected JSONException buildInvalidInputException() {
        return new JSONException("Input string is not well formed JSON (invalid char " + c + ")");
    }

    @SuppressWarnings("unchecked")
    protected List array() throws JSONException {
        final List ret = new ArrayList();
        Object value = this.read();

        while (token != ARRAY_END) {
            ret.add(value);

            final Object read = this.read();
            if (read == COMMA) {
                value = this.read();
            } else if (read != ARRAY_END) {
                throw buildInvalidInputException();
            }
        }

        return ret;
    }

    protected Object number() {
        buf.setLength(0);
        boolean toDouble = false;

        if (c == '-') {
            this.add();
        }

        addDigits();

        if (c == '.') {
            toDouble = true;
            this.add();
            addDigits();
        }

        if (c == 'e' || c == 'E') {
            toDouble = true;
            this.add();

            if (c == '+' || c == '-') {
                this.add();
            }

            addDigits();
        }

        if (toDouble) {
            return Double.parseDouble(buf.toString());
        } else {
            return Long.parseLong(buf.toString());
        }
    }

    protected Object string(final char quote) {
        buf.setLength(0);

        while (c != quote && c != CharacterIterator.DONE) {
            if (c == '\\') {
                next();

                if (c == 'u') {
                    this.add(unicode());
                } else {
                    final Object value = escapes.get(c);

                    if (value != null) {
                        this.add((Character) value);
                    }
                }
            } else {
                this.add();
            }
        }

        next();

        return buf.toString();
    }

    protected void add(final char cc) {
        buf.append(cc);
        next();
    }

    protected void add() {
        this.add(c);
    }

    protected void addDigits() {
        while (Character.isDigit(c)) {
            this.add();
        }
    }

    protected char unicode() {
        int value = 0;

        for (int i = 0; i < 4; ++i) {
            switch (next()) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                value = (value << 4) + c - '0';

                break;

            case 'a':
            case 'b':
            case 'c':
            case 'd':
            case 'e':
            case 'f':
                value = (value << 4) + c - 'W';

                break;

            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
                value = (value << 4) + c - '7';

                break;
            }
        }

        return (char) value;
    }
}
