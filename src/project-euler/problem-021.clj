(defn divisors [n]
      (filter #(zero? (rem n %)) (range 1 n)))

(defn divisor-sum [n]
      (reduce + (divisors n)))

(defn amicable [a]
      (let [b (divisor-sum a)]
        (when (and (not (= a b)) (= (divisor-sum b) a))
          b)))

(defn amicables [upper-bound]
      (filter (comp not nil?) (map amicable (range 1 upper-bound))))

(defn answer []
      (reduce + (amicables 10000)))
         

