---
title: System design basic
layout: post
categories: [HighFrequent]
---

# Methodology - how to go about system design?
1. Know some key components you can use 
2. Know how those components work with each other
3. Know how to make tradeoff, based on the problem 


# Key factors when designing a system
- Scalability
- Reliability 
- Availability
- Efficiency
- Managibility

# Load Balancing 
- Places to add LB
- Health check
- Benefits 
- Ways to distribute the load (least throughput, least active connection, round robin, weighted round robin etc.)
- Avoid LB to be a single point of failure

# Consisten Hashing
> index = hash_function(key), is not horizontally scalable, and is not load balanced
- Motivation of CH is to minimize the cost when there is a change (add / remove) to the servers in the auto scaling group
- How does it work? Imagine a cycle (ring)

# Caching
- Application server caching
- CDN (Content distribution network)
- Cache mechanism (write to both cache, and DB; write only to cache; write only to DB)
- Cache eviction policy(FIFO, LIFO, LRU, LFU, MRU, RR)

# Proxies
- a proxy server is a piece of software or hardware that acts as an intermediary for requests from clients seeking resources from other servers.
- Open proxy: anonymous proxy revels its identity as a server but does not disclose their initial IP address
- reverse proxy: a reverse proxy retrieves resources on behalf of a client, from one or more servers

# Data partitioning
- MySQL Interview questions: https://www.guru99.com/sql-interview-questions-answers.html
- Horizontal partitioning (split rows)
- Vertical Partitioning (store some columns in one place, and some other columns in other place)
- Partitioning Criteria (hash based, list, round robin, composite)
- Difficulty (join, referential integrity, rebalancing)

# Indexes
- Similar to binary search, when things are sorted, it is faster to search
- So essentially, we make a trade off between time and space (we create a new index, consuming memory to put the indexField+pointer, hoping for faster query)
- If the application requires lots of write, probably not worth it cause we are doubling the cost of each write

# Redundancy and Replication
- if there is only one copy of a file stored on a single server, then losing that server means losing the file.
- Replication means sharing information to ensure consistency between redundant resources, such as software or hardware components, to improve reliability, fault-tolerance, or accessibility.


# SQL VS NoSQL
- Relational databases are structured and have predefined schemas like phone books that store phone numbers and addresses.
- Non-relational databases are unstructured, distributed, and have a dynamic schema like file folders that hold everything from a person’s address and phone number to their Facebook ‘likes’ and online shopping preferences.

- MySQL, SQLite, Postgres,  Amazon Redshift
- 1) Key-value (Redis, Dynamo); Document (MongoDB); Wide Column DB (Cassendra, HBase); Graph DB(Neo4J)

## comparision
- Storage (each record is about an entity, each column is a datapoint)
- Schema(fixed v.s. dynamic)
- Query(SQL, structured query language; UnSQL, unstructured query language)
- Scalability (vertical scalable for SQL, easier for horizontal scaling for NON-SQL)
- ACID compliance (Atomicity, consitency, Isolation, Durability) = The vast majority of relational databases are ACID compliant. So, when it comes to data reliability and safe guarantee of performing transactions, SQL databases are still the better bet. While most of the NoSQL solutions sacrifice ACID compliance for performance and scalability.

## When to use what?
### SQL
- We need to ensure ACID compliance. (Finance etc)
- Data is structured and unchanged

### NoSQL
- Data is unstructured, and changing. 
- Cloud based storage
- Rapid development, Relational DB will slow the growth down

# CAP Theorem
> It is not possible for a distributed software system to simultaneously provide more than two out of three of the following guarantees (CAP): Consistency, Availability, and Partition tolerance. 

- Consistency: All nodes see the same data at the same time. Consistency is achieved by updating several nodes before allowing further reads.
- Availability: Every request gets a response on success/failure. Availability is achieved by replicating the data across different servers.
- Partition tolerance: The system continues to work despite message loss or partial failure. A system that is partition-tolerant can sustain any amount of network failure that doesn’t result in a failure of the entire network. Data is sufficiently replicated across combinations of nodes and networks to keep the system up through intermittent outages.


# Long-polling VS Websocket vs server-sent events
- How to detect new message has been sent? Poll 
  - Redundant empty responses? long poll

- Can server be "proactive"?
  - Websocket (bidirectional), push notification

# System design steps (methodology)
1. Clarify the requirement, and focus on the key features (~3)
2. Back of the envelope estimation, (scale, TPS, storage, bandwidth) 
3. System interface definition (API)
4. Defining data model (clarify how data will flow between different components of the system. Later, it will guide for data partitioning and management)
  * Which database system should we use? Will NoSQL like Cassandra best fit our needs, or should we use a MySQL-like solution? 
  * What kind of block storage should we use to store photos and videos?
5. High level design (core components)
6. Detailed design
  * data partitioning
  * uneven traffic distribution (some user tweet a lot, and majority just read)
  * Timeline (recent tweets) optimize scanning the latest tweets? 
  * which layer should we introduce cache?
  * which component required better LB?
7. Identify the resovle bottleneck
  * Is there any single point of failure in our system? 
  * data replication? 
  * server replication?
  * monitoring the performance of our service?

