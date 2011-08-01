(ns project_euler.problem-16
    [:require [project_euler [lib :as lib]]]
    [:require [clojure.contrib [math :as math]]])

(answer
  "Sum of the digits of the number 2^1000"
  (reduce + (digits (math/expt 2 1000))))
