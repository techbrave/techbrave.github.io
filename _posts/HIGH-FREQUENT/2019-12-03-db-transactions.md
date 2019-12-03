---
title: DB Transactions
layout: post
categories: [Zhuanti]
---

- Database ACID property
  - Atomicity: unit of work, all changes are performed as if they are a single operation. Full or nothing
  - Consistency: data is consistent when a transaction starts and when it ends. For account transfers, both funds in both accounts will state consistent at the start and at the end of each transaction
  - Isolation" Intermediate state of a transaction is invisible. As a result, transactions that run concurrently appear to be serialized
  - Durability: After a transaction successfully completes, changes to data persist are not undone, even in the event of a system failure.


- Why do we need DB transaction? 

Scenario: Me and my family uses the same Amazon account (with the same wallet). At the same time, both of us (on our phones) try to use this one account to purchase. Lets say I am going to spend $10, and my family is also going to spend $10. The result should be $80 (100 - 10 - 10). However, when thread 1 (my thread) sees the balance, it's 100, so it updates to 100-10. when thread 2 (at the same time) reads the balance, 100, it updates to 100-10=90. That's a buggy code. 

To avoid that, we introduce a concept of Lock. A lock has atomicity, meaning "full or nothing". If all the multiple statements cannot be finished in the same transaction, non of them will not happen at all. 
```java
{
    withdraw()
    deposit() // let's say we have some error here, so transaction will revert everything, including "withdraw"
    deductCommision()
}
```

- Concurrent operation on the same account at the same time?
My take: to keep consistency, we need to introduce some kind of Sequentiality

- Advantages of transaction
  1) Reliable unit of work + allow concurrent recovery + keep the data consistent
  2) Isolation from concurrent access

- How is the transaction lock implemented?
A generic way to implement is WAL (write ahead lock) 

Transaction related queries (all of them) will first be commited to the WAL. Before any write is happening, a lock will be acquired to the rows that are going to be modified. 

```java
acquireLock()
...
releaseLock()
```

- What is pessimistic lock? What is Optimistic Lock?

Pessimistic lock does not allow concurrent operation. 

Optimistic lock may allow concurrent read (dirty read), but it will only perform a write, when the version / snapshotId / hash / timeStamp is the same. 

time = 2: 
A: 14 / 2
B: 14 / 2
A: computes 17 (sees 2 as original version)
B: computes 15 (sees 2 as original version)

A slightly faster, compares 2 with 2, feels good, and updates 17 / 3(when a write is performed, version++)
B: slightly slower, compares 2 with 3, now cannot just write, must re-read the data and re-compute

Usecase:
 - Pessimistic lock: finantial database
 - Optimistic lock: dirty read allowed?

- What is MVCC (Multi version concurrency control)?

When to choose what?
- Few conflicts: maybe optimistic lock
- Lots of conflicts: maybe pessimistic lock

Pessimistic lock problem: Dead lock. Lock A and B both waiting for each other somehow. 

Ensure timeout, so it can mitigate dead lock

If using perssimistic lock: Persistent connection between application server (the thread that acquires the lock). Transaction Id to keep track of all queries. 

- Distributed transactions?
   - payment service
   - order service

2 phase commit (coordinator)
 - prepare
 - commit
 - definitely have a timeout

pro:
 - Strong consistency
con:
 - coordinator is single point of failure
 - locks in prepare stage (kind of a waste)
 - synchronous

3 phase commit (coordinator)
 - prepare
 - pre-commit
 - commit

any microservice can self elect to be the co-ordinator
the selected microservice can then start form the middle by understanding the state of "precommit"

SAGA: 
asynchronous

       [orchestrator]

user->orders service -> Queue -> customer wallet service -> queue2(rollback order) -> customer wallet rollback service