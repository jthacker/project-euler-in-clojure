(ns project_euler.problem-10
    [:use [project_euler.lib]])

(answer
  "Find the sum of all the primes below two million."
  142913828922
  (reduce + (lib/sieve 2000000)))
   
