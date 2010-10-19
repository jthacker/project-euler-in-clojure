(defn x [v] 
      (map second 
           (iterate 
             (fn [[a,b]] 
                 (let [a (inc a)] 
                   [a, (reduce + (take a v))])) 
             [1,1])))

(defn z [n] 
      (take (+ 2 n) 
            ((apply comp (repeat n x)) (iterate inc 1))))

(* 2 (reduce + (z 18)))
; Correct answer: 137846528820
