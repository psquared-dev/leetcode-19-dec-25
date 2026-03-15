package designguru01;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        // ToDo: Write Your Code Here.
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        String[] split = path.split("/");

        System.out.println(Arrays.toString(split));

        for (String s : split) {
            if (s.equals("..")) {
                stack.poll();
            } else if (!s.equals(".") && !s.isEmpty()) {
                stack.push(s);
            }
        }

        System.out.println(stack);

        Collections.reverse(stack);

        System.out.println(stack);

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"))    ;
    }
}
