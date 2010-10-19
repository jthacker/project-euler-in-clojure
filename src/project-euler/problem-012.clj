(ns project_euler.problem-12
    [:use [project_euler.lib]])

(defn triangle-numbers []
      (map first 
           (iterate (fn [[t n]]
                        [(reduce + (range 1 (+ 2 n))) (inc n)])
                    [1 1])))

(defn divisors [n]
      (filter #(zero? (rem n %)) (range 1 (+ 1 n))))

(answer 
  "What is the value of the first triangle number to have over five hundred divisors?"
  (first 
    (filter 
      #(< 500 (count (divisors %)))
      (triangle-numbers))))
