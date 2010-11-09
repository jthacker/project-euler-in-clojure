(def one-to-nineteen-map {
    1 "one"
    2 "two"
    3 "three"
    4 "four"
    5 "five"
    6 "six"
    7 "seven"
    8 "eight"
    9 "nine"
    10 "ten"
    11 "eleven"
    12 "twelve"
    13 "thirteen"
    14 "fourteen"
    15 "fifteen"
    16 "sixteen"
    17 "seventeen"
    18 "eighteen"
    19 "nineteen"})


(def tens-map {
    2 "twenty"
    3 "thirty"
    4 "forty"
    5 "fifty"
    6 "sixty"
    7 "seventy"
    8 "eighty"
    9 "ninety" }) 


(defn split-by-powers-of-ten
      "returns n as a coll of its digits in reverse"
      ([n]
       (reverse
         (map 
            #(Integer/parseInt (str %))
            (seq (str n)))))) 


(defn one-to-ninety-nine
      ([n]
       (cond 
         (<= n 0)
            nil
         (<= n 19)
            (get one-to-nineteen-map n)
         :else
            (let [[ones tens] (split-by-powers-of-ten n)]
              (if (zero? ones) 
                (get tens-map tens)
                (format 
                   "%s %s" 
                   (get tens-map tens) 
                   (get one-to-nineteen-map ones))))))) 


(def higher-powers '("hundred" "thousand"))


(defn spell-number
      ([n]
       (let [p (split-by-powers-of-ten n)]
         (if (= (count p) 1)
           (one-to-ninty-nine n)
           (let [first-two]))))) 

