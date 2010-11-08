(defn div-by?
      ([num d & divisors]
       (every? #(zero? (rem num %)) (cons d divisors))))


(defn leap-year?
      ([year]
       (if (div-by? year 100)
         (div-by? year 400 4)
         (div-by? year 4))))


(defn get-months-of
      ([year] 
       (let [months [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]]
         (if (leap-year? year)
           (map + months '(0 1 0 0 0 0 0 0 0 0 0 0 0))
           months))))


(def days-of-the-week '(:monday :tuesday :wednesday :thursday :friday :saturday :sunday))


(defn days-of-the-week-cycle
      ([] (days-of-the-week-cycle :monday))
      ([starting-dotw]
       (drop-while #(not= starting-dotw %) (cycle days-of-the-week))))


(defn partition-with
  ([parts coll]
     (lazy-seq
       (when-let [s (seq coll)]
         (let [n (first parts)
               rest-parts (rest parts) 
               p (take n s)]
           (cond
             (and (= n (count p)) (not (zero? (count rest-parts)))) 
               (cons p (partition-with rest-parts (drop n s)))
             :else
                (list (take n p))))))))


(defn sundays-on-the-first-of-the-month
      ([start-year end-year] 
       (count 
         (filter
            #(= (first %) :sunday)
            (partition-with 
               (flatten (map #(get-months-of %) (range start-year (inc end-year))))
               (days-of-the-week-cycle)))))) 
