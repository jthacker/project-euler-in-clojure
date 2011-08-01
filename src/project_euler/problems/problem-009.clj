(ns project_euler.problem-9
    (:require project_euler.lib)
    [:use [clojure.contrib math combinatorics]])

(defn equ [a b]
      (= 
        (+ a b (expt (+ (expt a 2) (expt b 2)) 1/2)) 
        1000))


(lib/answer
   "Find the pythagorean triplet such that a+b+c=1000 and give the product"
   31875000
   (let [[a b] (first (filter (fn [[a b]] (equ a b))
                              (combinations (range 500) 2)))
               c (- 1000 (+ a b))]
     (* a b c)))
