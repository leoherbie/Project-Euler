; The sequence of triangle numbers is generated by adding the natural numbers.
; So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
;
; 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
;
; Let us list the factors of the first seven triangle numbers:
;
;      1: 1
;      3: 1,3
;      6: 1,2,3,6
;     10: 1,2,5,10
;     15: 1,3,5,15
;     21: 1,3,7,21
;     28: 1,2,4,7,14,28
;
; We can see that 28 is the first triangle number to have over five divisors.
;
; What is the value of the first triangle number to have over five hundred divisors?
;******************************************************************************************************

;first attempt
(ns problems
  (:use [common :only (find-first, factor)] [clojure.contrib.pprint]))

(def triangle-sequence (map first
  (iterate
    (fn [[a b]]
      (let [[a b] [(long a) (long b)] new-b (long (inc b))]
        [(long (+ new-b a)) (long new-b)]))
  [1 1])))

(defn factors [n]
  "retrieves all the factors in n"
    (loop [candidates (range 1 (+ n 1)) facts #{}]
      (if (or (nil? candidates) (empty? candidates))
        facts
        (let [cand (first candidates)
              a-fact (factor cand n)
              new-candidates (rest candidates)]
          (cond
             (nil? a-fact) (recur new-candidates facts)
             (not (= a-fact cand)) (recur (range (first new-candidates) a-fact) (conj facts a-fact cand))
             true (recur new-candidates (conj facts a-fact)))))))

;should not start at the beginning of the triangle sequence obviously this sucks!
(println (time (find-first #(> (count (factors %)) 500) triangle-sequence)))



