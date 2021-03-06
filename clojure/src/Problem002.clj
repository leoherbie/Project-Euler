; Each new term in the Fibonacci sequence is generated by adding the previous two terms.
; By starting with 1 and 2, the first 10 terms will be:
;
; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
;
; Find the sum of all the even-valued terms in the sequence which do not exceed four million.
;******************************************************************************************************

; first attempt
(ns problems)

(defn fib-even-terms-sum [first second]
  "recursively calulates a fibonacci sequence
  adding all even-valued terms while the even terms are <= four million"
  (loop [f (int first) s (int second) sum-of-even 0]
    (if (> s 4000000)
      sum-of-even
      (recur (int s) (int (+ f s)) (if (even? s) (int (+ s sum-of-even)) (int sum-of-even))))))

(println (time (fib-even-terms-sum 1 1)))

;******************************************************************************************************

; second attempt (after reading PE solution)
(defn fib-even-terms-sum2 [first second]
  "recursively calulates a fibonacci sequence
  adding all even-valued terms while the even terms are <= four million"
  (loop [f (int first) s (int second) t (int (+ first second)) sum-of-even 0]
    (if (> s 4000000)
       sum-of-even
      (recur (int (+ s t)) (int (+ s t t)) (int (+ s t s t t)) (int (+ sum-of-even t))))))

(println (time (fib-even-terms-sum2 1 1)))

;******************************************************************************************************

; third attempt (after reading PE solution) - kinda slow but easy to read :-)
(def fib-sequence (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1])))

(println (time (apply + (filter even? (take-while #(< % 4000000) fib-sequence)))))
