; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;
; Find the sum of all the primes below two million.
;******************************************************************************************************

; first attempt
(ns problems
  (:use [common :only (prime?)]))

(defn sum-of-primes-below-limit [limit]
  (apply + (cons 2 (filter prime? (range 3 limit 2)))))

(println (time (sum-of-primes-below-limit 2000000)))
