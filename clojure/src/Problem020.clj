; n! means n × (n ? 1) × ... × 3 × 2 × 1
;
; Find the sum of the digits in the number 100!

; first attempt
(ns problems
  (:use [common :only (sum-of-digits-of-num)]))

(defn factorial-1 [num] (apply * (range 2 (inc num))))

(println (time (sum-of-digits-of-num (factorial-1 100))))

; second attempt - when I remove sum-of-digits-of-num call reduce is much slower that factorial-1 which uses apply. no clue why
(defn factorial-2 [num] (reduce * (range 2 (inc num))))

(println (time (sum-of-digits-of-num (factorial-2 100))))

; third attempt
(defn factorial-3 [num]
  (loop [cur num total 1]
    (if (= cur 1)
      total
      (recur (dec cur) (* total cur)))))

(println (time (sum-of-digits-of-num (factorial-3 100))))


