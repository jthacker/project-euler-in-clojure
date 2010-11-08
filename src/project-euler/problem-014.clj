(defn next-num [n]
      (if (even? n)
        (/ n 2)
        (+ 1 (* 3 n))))

(defn collatz-seq [start]
      (loop [v [start]]
         (if (= (first v) 1)
           v
           (recur (cons (next-num (first v)) v)))))

(defn start-number-of-largest-chain [limit]
      (loop [n 1
             max-count 0
             max-count-num 0]
            (let [current-count (count (collatz-seq n))]
              (cond 
                (= n limit) max-count-num
                (> current-count max-count) (recur (inc n) current-count n)
                :else (recur (inc n) max-count max-count-num)))))

(defn answer []
      (start-number-of-largest-chain 1e6))
