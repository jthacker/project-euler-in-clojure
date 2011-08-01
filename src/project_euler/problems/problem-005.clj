(ns project_euler.problem-5
    (:require project_euler.lib)
    (:use clojure.contrib.math))

(defn least-common-multiple
      ([] 1)
      ([x] x)
      ([x y] least-common-multiple x y 1)
      ([x y & more]
         (reduce *
            (map (fn [[k v]] (expt k v)) 
               (apply merge-with #(max %1 %2)
                  (map 
                     (fn [n] (frequencies (lib/prime-factors n))) 
                     (concat [x y] more)))))))

(lib/answer
   "Least common multiple for all the numbers between 1 and 20 inclusive"
   232792560
   (apply least-common-multiple (range 2 21)))
