const okta = require('@okta/okta-sdk-nodejs');

const client = new okta.Client({
  orgUrl: 'http://dev-552467.oktapreview.com',
  token: '00XiW-UesO8p4Pa2AmFM19_c_kfA8_l_Yk4QvZ3vqq'
});

module.exports = client;