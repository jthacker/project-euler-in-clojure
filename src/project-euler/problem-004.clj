(ns project_euler.problem-4
   (:require project_euler.lib)
   (:use clojure.contrib.combinatorics))

(defn is-palindrome? [x]
      (let [s (str x)]
         (= s (apply str (reverse s)))))

(lib/answer
  "Find the largest palindrome form the product of 2 3-digit numbers"
  906609
  (apply max
         (filter is-palindrome?
                 (map #(reduce * %) (combinations (range 100 1000) 2)))))
