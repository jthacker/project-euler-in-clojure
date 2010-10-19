(ns project_euler.problem-7
    (:require project_euler.lib))

(lib/answer
  "Find the 10001st prime number"
  104743
  (nth lib/primes 10000))
