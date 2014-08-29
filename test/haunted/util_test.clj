(ns haunted.util-test
  (:require [clojure.test :refer :all]
            [haunted.util :refer :all]))

(deftest room-builder-test
  (testing "Room-builder catches duplicate keys."
    (let [a {:a "a" :b "b"}
          b {:a "a" :c "c"}]
      (is (thrown-with-msg? Exception #"already defined key\(s\) a"
            ((room-builder "Test" a) b)))))

  (testing "Room-builder combines maps"
    (let [a {:a "a" :b "b"}
          c {:c "c" :d "d"}]
      (is (= {:a "a" :b "b" :c "c" :d "d"}
            ((room-builder "Test" a) c))))))


(deftest current-room-test
  (testing "current-room returns the current room"
    (let [st {:location :a
              :rooms {:a {:a "a"}
                      :b {:b "b"}}}]
      (is (= {:a "a"} (current-room st)))))

  (testing "current-room throws when location is nil"
    (let [st {:location nil}]
      (is (thrown-with-msg? Exception #"Illegal location error"
                            (current-room st)))))

  (testing "current-room throws when location key not in rooms hashmap"
    (let [st {:location :b
              :rooms {:a {:a "a"}}}]
      (is (thrown-with-msg? Exception #"Room not found for key :b"
                            (current-room st))))))