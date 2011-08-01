(ns project_euler.lib)

(defn answer 
      ([description actual] 
         (do 
           (println description) 
           (println (format "Answer: %s" actual))))
      ([description expected actual]
         (do
           (println description)
             (if (= actual expected)
               (println (format "Received expected answer: %s" actual))
               (println (format "Incorrect answer. Expected: %s but got: %s" expected actual))))))

(defn divisor? [n d]
      (zero? (rem n d)))

(defn is-prime? [n]
      (not-any? #(divisor? n %) (range 2 n)))

(def primes
  (concat 
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
	  (fn primes-from [n [f & r]]
	    (if (some #(zero? (rem n %))
		      (take-while #(<= (* % %) n) primes))
	      (recur (+ n f) r)
	      (lazy-seq (cons n (primes-from (+ n f) r)))))
	  wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
			6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
			2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

(defn sieve [n]
      (for [p primes :while (< p n)] p))

(defn prime-factors
      ([n] (prime-factors [] n 2))
      ([prime-factors n candidate]
         (cond
           (= n 1) prime-factors
           (= 0 (rem n candidate)) 
               (recur (conj prime-factors candidate) (quot n candidate) candidate)
           (> candidate (Math/sqrt n)) (conj prime-factors n)
           :else (recur prime-factors n (inc candidate)))))

(defn digits [n]
      (map #(Integer. (str %)) (str n)))
