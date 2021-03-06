(ns common)

(defn factor [f n]
  "how many times does is f a factor of n. returns nil if not a factor"
  (let [t (/ n f)] (if (ratio? t) nil t)))

(defn prime? [n]
  "is a number a prime number"

  (defn prime-rule [n]
    "implements one of the rules for detecting primes"
    (loop
      [r (Math/floor (Math/sqrt n))
      f 5]
      (cond
        (> f r) true
        (= (rem n f) 0) false
        (= (rem n (+ f 2)) 0) false
        true (recur r (+ f 6)))))

  (cond
    (= n 1) false ;1 is never prime
    (< n 4) true ;2 & 3 are prime
    (even? n) false ;all numbers but 2 are not prime
    (< n 9) true ;we have already excluded 4,6 and 8.
    (= (rem n 3) 0) false
    (prime-rule n) true
    true false))

(defn- f-of-digits-of [f num]
  (reduce #(f (Integer/valueOf (str %1)) (Integer/valueOf (str %2))) num))

(defn sum-of-digits-of [num]
  (f-of-digits-of + num))

(defn product-of-digits-of [num]
  (f-of-digits-of * num))

(defn find-first [pred coll]
  "Usage: (find-first pred coll)

  Returns the first item in a collection where the predicate is true.
  searches in linear time from first to last."
  (loop [c coll]
    (if (pred (first c))
      (first c)
      (recur (rest c)))))