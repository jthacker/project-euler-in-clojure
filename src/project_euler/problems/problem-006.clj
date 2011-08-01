(ns project_euler.problem-6
    (:require project_euler.lib)
    (:use clojure.contrib.math))

(defn triangle-inequality [& more]
      (-
        (expt (reduce + more) 2)
        (reduce + (map #(expt % 2) more))))

(lib/answer
  "Difference between the sum of squares and square of the sum for [1,100]"
  25164150
  (apply triangle-inequality (range 1 101)))
