(ns project-euler.problem-017
    [:require [project-euler [lib :as lib]]])

(def english-numbers { 
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
    19 "nineteen"
    20 "twenty"
    30 "thirty"
    40 "forty"
    50 "fifty"
    60 "sixty"
    70 "seventy"
    80 "eighty"
    90 "ninety"
    100 "hundred"
    1000 "thousand" })

        
; 1->19    106
; 1->9     36
; L(20,30,40,50,60,70,80,90)  46
; 20->29   L(20) * 10 + L(1->9)
; 30->39   L(30) * 10 + L(1->9)
; 20->99   L(20,30,40,50,60,70,80,90) * 10 + 8 * L(1->9)
; 1->99    L(20,...,90) * 10 + L(1->19) + L(1->9) * 8       854
; 100->199 (L(100) + L(and)) * 100 + L(1->99)
; 200->299 (L(200) + L(and)) * 100 + L(1->99)
