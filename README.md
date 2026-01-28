# Android IPC & Components Demo Application

## Project Overview

This Android application demonstrates inter-process communication (IPC) and interaction between different Android components. The app is built using Android's modern development stack and showcases how activities communicate with each other and with other system components.

## Project Structure

```
app2/
├── src/main/
│   ├── java/com/example/app2/
│   │   ├── MainActivity.java       # Main entry point with IPC demos
│   │   └── SecondActivity.java     # Secondary activity for inter-activity communication
│   └── res/
│       ├── layout/
│       │   ├── activity_main.xml   # UI layout for MainActivity
│       │   └── activity_second.xml # UI layout for SecondActivity
│       ├── values/
│       │   ├── strings.xml         # String resources
│       │   ├── colors.xml          # Color definitions
│       │   └── themes.xml          # Theme configuration
│       └── drawable/               # Drawable resources (icons, images)
```

## Features

The application demonstrates the following Android IPC mechanisms:

### 1. **Activity to Activity Communication**
- **File**: [MainActivity.java](app/src/main/java/com/example/app2/MainActivity.java)
- Navigate from MainActivity to SecondActivity using Intent
- Pass data between activities using Intent extras
- Message: "Hello from MainActivity!" is sent from the first activity

### 2. **User Interface**
- **MainActivity Layout** ([activity_main.xml](app/src/main/res/layout/activity_main.xml)): 
  - Displays 5 buttons for different IPC scenarios
  - Centered vertical layout with intuitive button labels
  
- **SecondActivity Layout** ([activity_second.xml](app/src/main/res/layout/activity_second.xml)):
  - Simple text display confirming navigation to the second activity

### 3. **Planned Components** (as shown in MainActivity layout)
- Activity to Activity
- Activity to Service
- Activity to System App
- Activity to Other App
- Activity to Broadcast Receiver

## Technical Details

### Technologies Used
- **Language**: Java 11
- **Min SDK**: Android 7.0 (API 24)
- **Target SDK**: Android 15 (API 36)
- **Build Tool**: Gradle (Kotlin DSL)

### Key Dependencies
- AndroidX AppCompat
- Material Design Components
- AndroidX Activity & ConstraintLayout
- JUnit & Espresso for testing

### Build Configuration
- **Build Gradle**: Kotlin-based DSL configuration
- **Target App ID**: com.example.app2
- **Version**: 1.0 (Code: 1)

## Getting Started

### Prerequisites
- Android Studio (latest version)
- Android SDK 36 or higher
- Java 11 or compatible JDK

### Installation & Build

1. **Clone/Extract the project**
   ```bash
   cd assamly
   ```

2. **Build the project**
   ```bash
   ./gradlew build
   ```

3. **Run the app**
   ```bash
   ./gradlew assembleDebug
   ```

### Running on Device/Emulator

1. Open the project in Android Studio
2. Connect an Android device (API 24+) or launch an emulator
3. Click **Run** → Select the target device
4. The app will install and launch automatically

## How It Works

### MainActivity Flow
1. User sees 5 buttons for different IPC demonstrations
2. Currently, the "Activity to Activity" button is implemented
3. Clicking it:
   - Creates an Intent to navigate to SecondActivity
   - Passes a message via Intent extras
   - Starts the SecondActivity

### SecondActivity Flow
1. Receives the Intent from MainActivity
2. Displays a confirmation message indicating successful navigation
3. Can retrieve the passed data using `getIntent().getExtra()`

## Code Highlights

### Intent Usage
```java
Intent intent = new Intent(MainActivity.this, SecondActivity.class);
intent.putExtra("message", "Hello from MainActivity!");
startActivity(intent);
```

This demonstrates basic Android IPC through Intent-based communication.

## Future Enhancements

The layout suggests the following features could be implemented:
- **Service Communication**: Start and bind to a Service
- **System App Integration**: Launch system apps (Camera, Gallery, etc.)
- **Cross-App Communication**: Communicate with other installed apps
- **Broadcast Receiver**: Handle system broadcasts

## Testing

The project includes test dependencies:
- **Unit Tests**: JUnit framework
- **Instrumented Tests**: Android Espresso framework

Run tests with:
```bash
./gradlew test                # Unit tests
./gradlew connectedAndroidTest # Instrumented tests
```

## Project Configuration

- **Namespace**: com.example.app2
- **Application Icon**: ic_launcher (default)
- **Theme**: Theme.App2 (customizable via themes.xml)
- **Backup**: Enabled with custom backup rules

## License

This is an educational assignment demonstrating Android IPC concepts.

## Notes

- The app currently implements Activity-to-Activity communication
- Other IPC buttons are present in the UI but not yet functional
- Code follows Android best practices with proper activity lifecycle management
- Uses AndroidX libraries for backward compatibility
