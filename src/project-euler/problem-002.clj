(ns project_euler.problem-2
    (:require project_euler.lib ))

(defn fib []
    (map first
        (iterate 
            (fn [[a b]] [b (+ a b)])
            [1 2])))

(lib/answer 
  "Sum of even valued fibonacci numbers from 1 to 4 million"
  4613732
  (reduce + 
           (for [n (fib) 
                   :while (< n 4e6) 
                   :when (even? n)] n)))
