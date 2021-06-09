import React from 'react';
import {Button, SafeAreaView, StatusBar} from 'react-native';
import MapView from './native/MapView';
import RNCamera from './native/RNCamera';
import RNShare from './native/RNShare';

const App = () => {
  return (
    <SafeAreaView style={{flex: 1}}>
      <StatusBar barStyle="dark-content" />
      {/* <MapView style={{ flex: 1 }} /> */}
      {/* <RNCamera style={{flex: 1}} /> */}
      <Button
        title="Share"
        onPress={async () => await RNShare.open({message: 'Message to share'})}
      />
    </SafeAreaView>
  );
};

export default App;
