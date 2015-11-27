#spring-social-fiware-lab
<a href="https://account.lab.fiware.org/" target="_blank">FIWARE Lab</a>'s Identity Manager (KeyRock) extension for <a href="http://projects.spring.io/spring-social/" target="_blank">Spring Social</a>


##Usage example

```
@Configuration
@EnableSocial
public class SocialConfiguration implements SocialConfigurer {

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
		cfConfig.addConnectionFactory(new KeyRockConnectionFactory(
			env.getProperty("fiwarelab.clientId"),
			env.getProperty("fiwarelab.clientSecret"))
		);
	}
	//...
}

```

Then provide a link to "/auth/fiwarelab", for example:
```
<a href="/auth/fiwarelab">Login with FIWARE Lab's IdM-KeyRock</a>
```


## TODO
- Package this project as a Maven artifact.


# License
The MIT License (http://www.opensource.org/licenses/mit-license.html)

Copyright (c) 2015 Tribalyte Technologies S.L. (http://www.tribalyte.com/)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
