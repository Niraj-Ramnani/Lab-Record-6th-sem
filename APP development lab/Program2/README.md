## AIM : To understand Activity, Intent, Create sample application with login module.(Check username and password).

### **Understanding Activity, Intent, and Login Module in Android**  

#### **Activity**  
An **Activity** represents a single screen in an Android application. It acts as the main entry point for user interaction. Every app has at least one activity, usually `MainActivity`, which is launched when the app starts.  

#### **Intent**  
An **Intent** is used to navigate between activities or pass data between them. It can be **explicit** (for launching a specific activity within the app) or **implicit** (for launching system applications like the camera or browser).  

#### **Login Module**  
A **Login Module** allows users to enter their credentials (username and password) and verifies them before granting access. It ensures security and can be implemented using static checks, local databases, or authentication APIs (e.g., Firebase).  

In our sample application, we created a **simple login module** where:  
1. The user enters a **username and password**.  
2. The credentials are validated in the `MainActivity`.  
3. A message is displayed based on the verification result.  

This demonstrates the basic functionality of activities, intents, and UI interaction in Android development. 🚀