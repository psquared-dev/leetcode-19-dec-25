package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        final String VALID_PATH = "[a-zA-Z_]+";
        final String PARENT_DIR = "..";

        System.out.println(Arrays.toString(split));

        for (String s : split) {
            if (s.matches(VALID_PATH)) {
                stack.push(s);
            } else if (s.equals(PARENT_DIR)) {
                stack.poll();
            }
        }

        System.out.println(stack);
        Collections.reverse(stack);
//        System.out.println(stack);

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
//        System.out.println(simplifyPath("/a//b////c/d//././/.."));
//        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home//foo/"));
    }
}
