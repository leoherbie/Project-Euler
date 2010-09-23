; The prime factors of 13195 are 5, 7, 13 and 29.
;
; What is the largest prime factor of the number 600851475143 ?

(defn factor? [f n]
  "is number f is a factor of number n" (and
   (< f n)
   (not (ratio? (/ n f)))))

(defn prime? [n]
  "is a number a prime number"
  (cond
    (= n 1) false
    (and (even? n) (> n 2)) false
    (= n 2) true
    true (not-any? #(factor? % n) (range 3 (- n 1)))
  ))

;need to start high and work my way down...
;(println (take 1 (filter #(and (factor? % 13195) (prime? %)) (reverse (range 2 13195)))))
