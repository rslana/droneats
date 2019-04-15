package controller;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raj
 */
public class MethodFactory {

    public static Method create(String methodName, Object obj) {
        try {
            return obj.getClass().getDeclaredMethod(methodName, obj.getClass());
        } catch (NoSuchMethodException | SecurityException ex) {
            Logger.getLogger(MethodFactory.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
