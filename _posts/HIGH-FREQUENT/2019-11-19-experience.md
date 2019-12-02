---
title: Project related
layout: post
categories: [HighFrequent]
---


# Caching
- MemcacheD

# Spark? Pyspark analytics 
--- 

# Load balancing? 

# TPS generator

# Automated alarms

# Building a website (Python flask)

# Authentication (cloud-auth)

# Alexa skills kit 
My intern project in Alexa skill kits is to build a dashboard that can monitor the failure of the system. 
Alexa skills kit provides a public facing interface, such that you can configure your services (often Lambda) to handle the commands (direct) from Alexa customer. 

user -> Alexa Cloud service -> 3p (skills) -> My lambda / my service -> Alexa Cloud Service -> user

The benefit: (1) lots of demos to learn how to build a simple Alexa skill (2) great way to promote your expeirence / product to a very wide audience. 
The hard part: a) some limitations between 1p and 3p parity. For example, we know in 1p skills, we can launch one skill to each other. But once it is in a 3p session, it is "locked" into that session. b) Alexa SDK has its limitations, so 3p developers are not likely to get the full fledge capability of Alexa. For example, it will only get the "interpretatoin" after NLU, not the raw text  c) sometimes the skill owner need to implement complex logic per defined by the contract (e.g. catalog search ...) 

# My personl project on Wechat mini program

# Elastic Search // https://www.onlineinterviewquestions.com/elasticsearch-interview-questions/

I have used Elastic search mostly on the project to match question variants - If we treat it as a search problem : ach question is a "document".  
It includes harvesting common questions, index them . Experiment with fields (synonyms expansion ... stopwords)
Experiment with ranker ...

# NLP related // https://www.onlineinterviewquestions.com/nlp-interview-questions/

## What is NLP?
Natural Language Processing or NLP is an automated way to understand or analyze the natural languages and extract required information from such data by applying machine learning Algorithms

## key components of NLU?
- tokenization
- Part of speech tagging
- Dependency parsing
- entity extrction
- syntatic analysis (ordering)

named entity recognition (mentions)
entity resolution(distinguish between mentions)

# Relational database questions
What is your experience in using relational database? (Frequently asked questions, Catalog metadata...)
Amazon Redshift?

# Non-reltional database question
What is your experience in using Mongo DB? 

# S3
We use this a lot

# SQS / SNS

