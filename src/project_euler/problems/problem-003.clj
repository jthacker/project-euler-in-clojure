(ns project_euler.problem-3
   (:require project_euler.lib))

(def n 600851475143)

(lib/answer
   (format "Find the largest prime factor of %s" n)
   6857
   (apply max (lib/prime-factors n)))
