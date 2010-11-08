(defn triangle-numbers []
      (map first 
           (iterate (fn [[t n]]
                        [(reduce + (range 1 (+ 2 n))) (inc n)])
                    [1 1])))

(defn divisors [n]
      (filter #(zero? (rem n %)) (range 1 (+ 1 n))))

(defn first-triangle-number-with-over-n-divisors [n]
      (second (first (filter #(> (first %) n) (map (fn [m] [(count (divisors m)) m]) (triangle-numbers))))))
