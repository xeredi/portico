package xeredi.argo.model.metamodelo.proxy;

import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import lombok.NonNull;
import xeredi.argo.model.metamodelo.vo.TipoElemento;
import xeredi.argo.model.metamodelo.vo.ValidacionKeyword;
import xeredi.argo.model.metamodelo.vo.ValidacionVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ValidacionProxy.
 */
public final class ValidacionProxy {

    /**
     * Instantiates a new validacion proxy.
     */
    private ValidacionProxy() {
        super();
    }

    /**
     * Generate.
     *
     * @param tipoElemento
     *            the tipo elemento
     * @param validacionString
     *            the validacion string
     * @return the validacion VO
     */
    public static ValidacionVO generate(@NonNull final TipoElemento tipoElemento, final String validacionString) {
        if (validacionString == null) {
            return null;
        }

        final ValidacionVO vldn = new ValidacionVO();
        final StringTokenizer tokenizer = new StringTokenizer(validacionString, ";");

        while (tokenizer.hasMoreTokens()) {
            final String ruleToken = tokenizer.nextToken().trim();
            ValidacionKeyword rule = null;

            for (final ValidacionKeyword keyword : ValidacionKeyword.values()) {
                if (ruleToken.startsWith(keyword.name())) {
                    rule = keyword;
                }
            }

            if (rule == null) {
                throw new Error("Regla inválida: " + ruleToken);
            }

            final String arguments = ruleToken.substring(rule.name().length()).trim();

            if (arguments.isEmpty() || !arguments.startsWith("(") || !arguments.endsWith(")")
                    || (arguments.length() < 3)) {
                throw new Error(rule.name() + ": Argumentos no válidos");
            }

            final String argumentList = arguments.substring(1, arguments.length() - 1).trim();

            switch (rule) {
            case regexp:
                try {
                    vldn.setRegexp(Pattern.compile(argumentList));
                } catch (final PatternSyntaxException ex) {
                    throw new Error(rule.name() + " ha de ser una expresión regular válida");
                }

                break;
            case minLength:
                try {
                    vldn.setMinLength(Integer.parseInt(argumentList));
                } catch (final NumberFormatException ex) {
                    throw new Error(rule.name() + " ha de tener como argumento un número entero");
                }

                break;
            case maxLength:
                try {
                    vldn.setMaxLength(Integer.parseInt(argumentList));
                } catch (final NumberFormatException ex) {
                    throw new Error(rule.name() + " ha de tener como argumento un número entero");
                }

                break;
            case minValue:
                switch (tipoElemento) {
                case NE:
                    try {
                        vldn.setMinValue(Long.parseLong(argumentList));
                    } catch (final NumberFormatException ex) {
                        throw new Error(rule.name() + " ha de tener como argumento un número entero");
                    }

                    break;
                case ND:
                    try {
                        vldn.setMinValue(Double.parseDouble(argumentList));
                    } catch (final NumberFormatException ex) {
                        throw new Error(rule.name() + " ha de tener como argumento un número decimal");
                    }

                    break;

                default:
                    throw new Error(tipoElemento.name() + " No implementado");
                }

                break;
            case maxValue:
                switch (tipoElemento) {
                case NE:
                    try {
                        vldn.setMaxValue(Long.parseLong(argumentList));
                    } catch (final NumberFormatException ex) {
                        throw new Error(rule.name() + " ha de tener como argumento un número entero");
                    }

                    break;
                case ND:
                    try {
                        vldn.setMaxValue(Double.parseDouble(argumentList));
                    } catch (final NumberFormatException ex) {
                        throw new Error(rule.name() + " ha de tener como argumento un número decimal");
                    }

                    break;

                default:
                    throw new Error(tipoElemento.name() + " No implementado");
                }

                break;
            default:
                throw new Error(rule.name() + " No implementado");
            }
        }

        return vldn;
    }
}
