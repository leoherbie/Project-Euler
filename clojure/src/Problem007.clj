; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;
; What is the 10001st prime number?
;******************************************************************************************************

; first attempt
(ns problems
  (:use [common :only (prime?, factor)]))

(defn find-nth-prime [n]
  "finds the nths prime. n >= 1"
  ;special case
  (if (or (= n 2) (= n 3))
    (- n 1)
    (loop [num-primes-found 2 last-num-processed 3]
      (let [cur-num (+ last-num-processed 2) prime (prime? cur-num)]
        (cond
          (and prime (= (inc num-primes-found) n)) cur-num
          prime (recur (inc num-primes-found) cur-num)
          (not prime) (recur (identity num-primes-found) cur-num))))))

(println (time (find-nth-prime 10001)))