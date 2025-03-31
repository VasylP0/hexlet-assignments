package exercise;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    public static List<String> validate(Object obj) {
        List<String> invalidFields = new ArrayList<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        invalidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return invalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> violations = new HashMap<>();

        for (Field field : obj.getClass().getDeclaredFields()) {
            List<String> fieldErrors = new ArrayList<>();
            field.setAccessible(true);

            try {
                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    fieldErrors.add("can not be null");
                }

                if (field.isAnnotationPresent(MinLength.class) && value != null) {
                    MinLength annotation = field.getAnnotation(MinLength.class);
                    int minLength = annotation.value();
                    if (value instanceof String str && str.length() < minLength) {
                        fieldErrors.add("length less than " + minLength);
                    }
                }

                if (!fieldErrors.isEmpty()) {
                    violations.put(field.getName(), fieldErrors);
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return violations;
    }
}
