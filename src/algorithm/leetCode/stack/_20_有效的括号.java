package algorithm.leetCode.stack;

import java.util.HashMap;
import java.util.Stack;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2403 👎 0
public class _20_有效的括号 {

    /**
     * 检查输入字符串是否是有效的括号序列。
     * 使用循环和字符串替换来消除匹配的括号对。
     * 
     * @param s 输入的括号序列
     * @return 如果输入的括号序列有效，则返回 true；否则返回 false
     */
    public boolean isValid1(String s) {
        // 循环持续检查和消除匹配的括号对，直到字符串中不再包含任何括号对
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            // 使用字符串替换方法将匹配的括号对替换为空字符串，相当于消除了一个括号对
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }
        // 循环结束后，如果字符串变为空字符串，则返回 true，表示输入的括号序列是有效的
        // 否则返回 false
        return s.isEmpty();
    }

    /**
     * [{()}]
     * 1.判断遇见的是左字符，将左字符入栈
     * 2.遇见右字符
     * a.如果栈为空，说明括号无效
     * b.如果栈不为空，将栈顶字符出栈，与右字符匹配
     * 如果左右字符不匹配，说明括号无效
     * 如果匹配，继续扫描下一个字符
     * 3.所有的字符扫描完毕后
     * 如果栈为空，则括号有效
     * 如果栈不为空，说明括号无效
     * 
     * @param s 输入的括号序列
     * @return 如果输入的括号序列有效，则返回 true；否则返回 false
     */
    public boolean isValid2(String s) {
        // 创建一个字符类型的栈，用于存储左括号
        Stack<Character> stack = new Stack<Character>();

        // 遍历输入字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (charAt == '(' || charAt == '{' || charAt == '[') {
                // 如果字符是左括号，则将其压入栈中
                stack.push(charAt);
            } else {
                // 如果字符是右括号
                if (stack.isEmpty()) {
                    // 如果栈为空，说明右括号没有匹配的左括号，返回 false
                    return false;
                }

                // 从栈顶弹出一个左括号
                char left = stack.pop();
                // 检查左右括号是否匹配，如果不匹配，返回 false
                if (left == '(' && charAt != ')') {
                    return false;
                }
                if (left == '{' && charAt != '}') {
                    return false;
                }
                if (left == '[' && charAt != ']') {
                    return false;
                }
            }
        }

        // 如果栈为空，说明所有左括号都有匹配的右括号，返回 true
        // 否则返回 false
        return stack.isEmpty();
    }

    /**
     * 检查输入字符串是否是有效的括号序列。
     * 使用哈希映射和栈来实现括号的匹配检查。
     * 
     * @param s 输入的括号序列
     * @return 如果输入的括号序列有效，则返回 true；否则返回 false
     */
    public boolean isValid3(String s) {
        // 创建一个哈希映射，存储左括号和右括号的映射关系
        HashMap<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('(', ')');
        map.put('[', ']');

        // 创建一个字符类型的栈，用于存储遇到的左括号
        Stack<Character> stack = new Stack<>();

        // 遍历输入字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果当前字符是左括号，则将其压入栈中
                stack.push(c);
            } else {
                // 如果当前字符是右括号
                if (stack.isEmpty()) {
                    // 如果栈为空，说明右括号没有匹配的左括号，返回 false
                    return false;
                }
                // 从栈顶弹出一个左括号
                char left = stack.pop();
                // 检查当前右括号是否与弹出的左括号匹配，如果不匹配，返回 false
                if (c != map.get(left)) {
                    return false;
                }
            }
        }

        // 如果栈为空，说明所有左括号都有匹配的右括号，返回 true
        // 否则返回 false
        return stack.isEmpty();
    }

}
