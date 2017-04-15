/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xeredi.edifact;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving descriptiveError events. The class that
 * is interested in processing a descriptiveError event implements this
 * interface, and the object created with that class is registered with a
 * component using the component's <code>addDescriptiveErrorListener<code>
 * method. When the descriptiveError event occurs, that object's appropriate
 * method is invoked.
 *
 * @author xeredi
 */
public final class DescriptiveErrorListener extends BaseErrorListener {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		String sourceName = recognizer.getInputStream().getSourceName();
		if (!sourceName.isEmpty()) {
			sourceName = String.format("%s:%d:%d: ", sourceName, line, charPositionInLine);
		}

		System.err.println("KK: " + sourceName + "line " + line + ", column " + charPositionInLine + " " + msg);
	}

}
