(ns com.foo.aws.core)

(defn reverso [halb]
  (.join (.reverse (.split halb "")) ""))
