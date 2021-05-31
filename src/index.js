import React from "react";
import { SafeAreaView, StatusBar, Text } from "react-native";
import MapView from "./native/MapView";
import RNCamera from "./native/RNCamera";

const App = () => {
  return (
    <SafeAreaView style={{ flex: 1 }}>
      <StatusBar barStyle="dark-content" />
      <MapView style={{ flex: 1 }} />
      {/* <RNCamera style={{flex: 1}} /> */}
    </SafeAreaView>
  );
};

export default App;
