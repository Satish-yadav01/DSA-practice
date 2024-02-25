package interviewBasics.revision.comparator;

import java.util.Comparator;

class IdComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getId() - o2.getId();
    }
}
