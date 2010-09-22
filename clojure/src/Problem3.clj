; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?

(defn prime? [n]
  "is a number a prime number not including 1"
  (cond
    (= n 1) false
    (and (even? n) (> n 2)) false
    (= n 2) true
    ;call function to determine non-special cases
  ))

(defn factor? [f n]
  "is number f is a factor of number n" (and
   (< f n)
   (not (ratio? (/ n f)))))

(println (prime? 5))