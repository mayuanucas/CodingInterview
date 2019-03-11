package algorithm.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: 员工的重要性
 * @date: 2019/03/11
 */
public class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        if (null == employees || 0 >= employees.size()) {
            return 0;
        }

        HashMap<Integer, Employee> map = new HashMap<>(employees.size());
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return getImportance(map, id);
    }

    public int getImportance(Map<Integer,Employee> map, int id) {
        Employee emp = map.get(id);
        int ans = emp.importance;
        for (Integer n : emp.subordinates){
            ans += getImportance(map, n);
        }
        return ans;
    }

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
