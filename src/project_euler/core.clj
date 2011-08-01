(ns project_euler.core
    (:use clojure.contrib.logging))

; lein run 2 --test     Runs tests for problem #2 if it exists and has tests
; lein run 2            Runs the solution for problem #2 if it exists and checks solution
; Each solution should somehow register itself as being a solution to a given problem
; -- what about the case of multiple solutions
; Start a timer that lets the user know when a minute has passed and the solution has not finished yet
; -- This should happen for each of the tests as well
; Solutions should be timed

(def *problems* (ref {}))

(defn run-problem [num] )

(defn list-problems )

(defn -main []
      (let [[problem-number test?] *command-line-args*]
        (if problem-number
          (run-problem problem-number)
          (list-problems))))

(defn problem [num description]
      (dosync 
        (let [problem-map @*problems*]
          (if (contains? problem-map num)
            (warn
              (format "Warning: registering a problem that has already been declared %s" num))
            (do
              (info (format "Registering problem %s -- %s" num description))
              (ref-set *problems*
                       (assoc problem-map num description)))))))

(defn answer [func expected-value])

(defn verify [func expected-value])
