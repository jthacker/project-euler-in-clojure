(ns project_euler.problem2
    (:require project_euler.lib))

(defn fib
    (map first
        (iterate 
            (fn [[a b]] [b (+ a b)])
            [1 2])))

(defn fib-even [end]
  (reduce + 
           (for [n (fib) 
                   :while (< n end) 
                   :when (even? n)] n)))

(defn answer []
      (lib/problem "Sum of even valued fibonacci numbers from 1 to 4 million"
                   #(fib-even 4e6) 4613732))
