package extrapackage;

import java.math.BigDecimal;
  
public interface PriorityQueue {
        public void insert(Integer key, double value);

        public Object removeMin();

        public Object min();

        public int size();

        public boolean isEmpty();
    }