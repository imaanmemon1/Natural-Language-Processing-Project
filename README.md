# Unit 6 - Natural Language Processing Project

## Introduction

Natural language processing (NLP) is used in many apps and devices to interact with users and make meaning of text to determine how to respond, find information, or to create new text. Your goal is to use natural language processing techniques to identify structure, patterns, and meaning in a text to have conversations with a user, execute commands, perform manipulations on the text, or generate new text.

## Requirements

Use your knowledge of object-oriented programming, ArrayLists, the String class, and algorithms to create a program that uses natural language processing techniques:

- **Create at least two ArrayLists** – Create at least two ArrayLists to store the data used in your program, such as data from text files or entered by the user.
- **Implement one or more algorithms** – Implement one or more algorithms that use loops and conditionals to find or manipulate elements in an ArrayList or String object.
- **Use methods in the String classs** - Use one or more methods in the String class in your program, such as to divide text into sentences or phrases.
- **Use at least one natural language processing technique** – Use a natural language processing technique to process, analyze, and/or generate text.
- **Document your code** – Use comments to explain the purpose of the methods and code segments and note any preconditions and postconditions.

## UML Diagram

![Copy of Copy of Unit 6 - UML Diagram](https://github.com/user-attachments/assets/9b51656e-55c7-4673-be85-e6015f9269ad)


## Video

Record a short video of your project to display here on your README. You can do this by:

- Screen record your project running on Code.org.
- Upload that recording to YouTube.
- Take a thumbnail for your image.
- Upload the thumbnail image to your repo.
- Use the following markdown code:

[![Thumbnail for my projet](nameOfThumbnail.png)](youtube-URL-here)

## Project Description

The goal of this application is to summarize text by identifying and extracting key sentences. The program analyzes text files, such as Tangled.txt Cinderella.txt LittleRedRidingHood.txt & SnowWhite.txt, by reading and processing the content into words and sentences. Users interact with the project by selecting a story file and specifying the number of sentences they want in the summary. The program then displays a concise version of the story based on important words and sentence scoring.

## NLP Techniques

This project incorporates stopword removal to improve text summarization.

(Implemented in processFile() and scoreSentences())

Filters out common words (the, and, is, in, etc.) that don’t add meaning to the summary.
Ensures only meaningful words contribute to sentence scoring.
