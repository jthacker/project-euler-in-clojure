(defn factorial
      ([n]
       (if (zero? n) 
         1
         (reduce * (range 1 (inc n))))))

(defn digits
      "returns a collection of the digits in integer n"
      )
