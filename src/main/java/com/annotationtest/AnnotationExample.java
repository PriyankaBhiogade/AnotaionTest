package com.annotationtest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
public class AnnotationExample {
        @Override
        @MethodInfo(author = "Priyanka", comment = "Main Method", date = "Nov 26 2019", revision = 1)
        public String toString() {
            return "Overridden toString method";
        }

        @Deprecated
        @MethodInfo(comment = "deprecated method", date = "Nov 26 2019")
        public static void oldMethod() {
            System.out.println("old method, don't use it.");
        }

        public static void main(String[] args) {
            try {
                for (Method method : AnnotationExample.class.getMethods()) {
                    if (method.isAnnotationPresent(MethodInfo.class)) {
                        try {
                            for (Annotation anno : method.getDeclaredAnnotations()) {
                                System.out.println("Annotation in method" + method + ":" + anno);
                            }
                            MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                            if (methodAnno.revision() == 1) {
                                System.out.println("Method with revision no 1 = "+ method);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

