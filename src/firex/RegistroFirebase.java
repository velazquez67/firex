package firex;

public class RegistroFirebase
{
	String type;
	String project_id;
	String private_key_id;
	String private_key;
	String client_email;
	String client_id;
	String auth_uri;
	String token_uri;
	String auth_provider_x509_cert_url;
	String client_x509_cert_url;

	public RegistroFirebase()
	{ /*
		 * Para generar una nueva configuracion de acceso ingresar a appengine IAM y
		 * administracion, Cuentas de servicio: Administrar claves de firebase-admin
		 * y AGREGAR CLAVE
		 */
	}

	public RegistroFirebase tecZacatepec()
	{
		type = "service_account";
		project_id = "teczacatepec";
		private_key_id = "8f1c92a26f50159e45c1225d5bdbc4be306353b7";
		private_key = "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCawHq9iVwjDzoY\nEYhgZjG34hVyZ37P2wEsaGlcWzyel0m5e8CAYDj5L8cKVi/Y7Pla9Jzq+DH6PI/E\n+XUgq6v5d9Hg4W/pPkh1tVt1qxs8KypfCVde9GxWoiKgxx6QGRsm1n0ZoX8f7RMI\nc6emQABj84zPrFiiKzxkMtoX0ErvFQeIrIlBtPD4Oz/IJrdW799rMx9NYtHZLOR5\nrdX61PBBX/xSNcSZNRiXlvCOoc8SXi/vzPmfROeKIThSfhYGlXa8GeEjliPTfXtF\n3ajoWMwG3EJzVSTgq+jxUb2XQxQWwuosXvL9EK8DHe0ESaIkAqtgklD77xmfVUv/\nINxRhgDnAgMBAAECggEAJIM7spLBSYhjNaCVY+FY48EVPFwNAK/0s+yix2bDg8vA\nWmJHhkKtzqWmOdsiCPXI09wZVhtfd2JorZoKN74pon/R5lRqmkbWw+cZgEbx8x1g\nLvI+SiozkbFJqFOy817pGB3NgImpO/gs4HahXMmHDg498BYDB6hZ5G5XJP1BYO1f\n9IkKYqVIdjRiV6mCtvSq8ZWG75K3u9q0YozT1fTH+0DDvahV832DyiJlHt6/VIBp\nZZx5BOwcW+OkRqY0nsSSBMTrNOVV64j5fMXZ9nDaACHVNrH3/HvRnEsYb/g7cm27\nPLBb3izbIVfBJnyhDaFuM73VZvA+9VeVkYnZeYi3SQKBgQDawQIicB1osUu4jJcY\nn4c8oMB7RCvWV00iRqV7muI/tUcQtmutHUeWHlaMFoukV3JCpdhp/hjP6YsHEjPs\nl+OSk+xXMmD3jHa+wexGaH3zOSSpWsyzfQhk/76J0oRpv9IuZvnl76/PYifxvFsO\nbWFlEl53xGi7lOW7T7i1oDdEkwKBgQC1GcPh0No3ejpEmGyQwJc94UUv2MdXtnsL\n7xntwbtlEcnViGsE5R1Z0ZshNzUKNfNtpPr9oqS+xetvR8PO7FDlLYKE9kgELorR\nJd47+DevBHPyKA8lHB8eSkS7n4RACplsrYL5cQgMJMMlxnyqSn89LjMq1wtcTyp2\nn+MkkS+63QKBgGR2k5ZhSwBTvGTLHHFQgnlTklKKIl/TxDbjnwg/P3zmsfZ48MaW\nVdQZpsG7cPJOvsjhBZzX92k05oae033q27brfHUnS+UkezxsLyi+wGk9axrj+nLM\nD1jjIwyExA8U62AoJsh05ZcmixW33VGo5jvWzc/PQhIz9bWqjTfMltVFAoGAKgcN\nr1URnzhNV2fsIfef4atqq/zp3hAqJA3b/ZItE/p51YUwGNW25wY+swml1HXKxVI5\nMS1SgDdcONn1tgqfh1/1XzfsZJQMgRcBqPckrQgihDsJsLoC+ruPkd8mCNqs2ky2\nDX9Ot8q8QwL6IWbiemdDVpjLOSPiHd9jDjRnWD0CgYA6SFIk4zVj870UadqnvwL4\ndXnEiSKvaqXioB9M2MMUJPldeS4UXsBeMgANZLVCV0cNbYZTHjJ7aB/YaAxofGS6\n0wEHMgRjU1/S30RE+ZNAtmxasejV82Ms4bgSIEqPFYFDpbWEj0O8m3TFhpnxkqv6\ngyvwrUVcoIBqzQqyJ51NmQ==\n-----END PRIVATE KEY-----\n";
		client_email = "firebase-adminsdk-187sk@teczacatepec.iam.gserviceaccount.com";
		client_id = "102157903454254975739";
		auth_uri = "https://accounts.google.com/o/oauth2/auth";
		token_uri = "https://oauth2.googleapis.com/token";
		auth_provider_x509_cert_url = "https://www.googleapis.com/oauth2/v1/certs";
		client_x509_cert_url = "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-187sk%40teczacatepec.iam.gserviceaccount.com";
		return this;
	}

	public RegistroFirebase tecnamex()
	{
		type = "service_account";
		project_id = "tecnamex";
		private_key_id = "b71d323c8fbf435cf21a1bae03d495dd99245f90";
		private_key = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCbv/4pcacVSM/q\n7Mns24imeNGT3P5iXt216xJrr7eDl0EZ3marx4MnOMB0l46E7kJ1oKWj8CWEuZiq\nnGV3+eYfAvI/ZT2ufemhW/v0xuuGavO6NhDXtIaGgngHAq70c83amtfkHm0/4LAm\ndR9x4mHooZRGZ2JBJCGfOt08x+2KxLthNqD0GuOU3UQw3VoFbiNoDnUr4kXB7HO0\nI2sLmgi6fNIGK4tC6I+3qdtOL3kPErSLFwGF4zlr5f1S82T7AZryWF2Bpic7N9C2\nFA7Ac9Iscqm7bUrXPayi3TwFJxeRgKa1p3clgukxGtpf5jcdReg1PNpgh9L7u7gP\n4EP3bJIHAgMBAAECggEAQfdb4VbLQycPNPusfJ7w7j0+2scfkS+H7QyOxUBr1BbE\nkn3Rc5ExmfOeA+PLD79QM7ziWyCT63amVCCgk2OrFVhsnPA240heIyMwAFkeGVUE\nPMq4cHv7/E2XI7T9v/iqaBvsM6i1cfgq82bo9hXBjUOeZwFTqq5wdR375UnycLLA\nUj5H9PruzE11qx0oxV/kW/YavXBkc3em14ycSKFJKg7GnJYtp25Jt8DJ2bhlyhrM\nRPgPZ3x1nWTJsFsdXf5PcZnU6t5oufbELCzT7p4Nt+yd+GQeeqo356TlquwmcWyE\nEyyniI+33eCwJegWVMRP1x+QLXq2sDGgsDMPiK5yeQKBgQDLroCDfOJ2pSBw59xq\nlRMO/eAW/lA06EoocFBwfeRDJeXkmRvAL4nrHy5P+JrGFKRZTA1ButggWF5DgpNv\n1QjSYKemPDS6l6sRkSiVH7H3+BtKlXnqCS7/w2elR0TCCa7i7XYyKUU5TUVjHmvM\nOUQWXQG+B00QwtC50jQNAbUWmQKBgQDDwaWLa9vo5HcND2/bsVVCDzaJkOJkaM1W\nl9yzdmdPsToI1lYli4iA6Znge6xN/BTFx7mkRtUGLiXbqPolU67B/n4xkBa+3rMp\nphyiyh3g2FPeNbKbq8ZMm3ZCXClmryQRhfUQ8H+D1jKRr+/LBnBZOvhp7NhQTdKt\nsO+mLwpxnwKBgB46/SoG3Bnd8k2vrCBJlfWQqrTe9AqWO4N7AAViOgHZWyCttNe2\ndpLmItqNvHMP10DFr+YElFVgqET+2WEszk1jOR7MKstS/XnzAIH5nVF/ipVsUBbz\nW/1sBDMcu9DM3R8jPXq+c17I4DaQ6lD6Yueq0DpjHQYS1CXwU/dmPHlpAoGBALwM\n0afepHHUz5znQHCOqTV9gcmjOih1GRTfa++mhdZjjTmiFT2aDjawsdaZV8vOpnHc\nzLRIKyn1uP6MFEk5W38WqEmafo87RmdzIL0tZohxqBemA/9Rg3xiN7fF6yuugfqn\nceWk8wpGAWw81CF3/QNrB+pR0PdL22Bpwb4mIGVHAoGAccaXz3AFRFIA83aHk7aO\nfGKmbTbw3Vj85uMPNocr06MmHERzCdmtpGLi5hle/ZdRDeGz3M3rH6t5JnuUKqdH\nNvKjE8zWrRaqQDNxLcTsxqlYh4XoKhQv/UF0QZdvnxsFdma/JjOHMQ1LnC9hjBR0\nmunD2SToi+7+X+nLE2pAmMI=\n-----END PRIVATE KEY-----\n";
		client_email = "firebase-adminsdk-yfk4x@tecnamex.iam.gserviceaccount.com";
		client_id = "102897859616162179816";
		auth_uri = "https://accounts.google.com/o/oauth2/auth";
		token_uri = "https://oauth2.googleapis.com/token";
		auth_provider_x509_cert_url = "https://www.googleapis.com/oauth2/v1/certs";
		client_x509_cert_url = "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-yfk4x%40tecnamex.iam.gserviceaccount.com";
		return this;
	}

	public RegistroFirebase aspirantesitz()
	{

		type = "service_account";
		project_id = "aspirantesitz";
		private_key_id = "325b792f06ec80d78b5c38fe48168e771ea23f55";
		private_key = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQC14RNuJaEMs7dS\nbT3/ZfXUVswxHVQoXDyvmvFot9Io7dJ9K7rTmwPidM8HQ5vnrSTGxdbAwO86Jtgt\n4Z1BCBfVWjKClbcKwalUO/uKTFwZOCcmnb7t1qLPHLRP+03hfCDlbvpgOtY10a1Z\n6U6+BPXC7Spl6FB8tHfJYuSXkV0gdNHe6Z3CG372fQ7xb2pNkDNLgS8sFSSH3qHy\n00D5fwhi7qgdMWo5E9wUvMltJgWqc+f6BLtAVWZBvyWun77Ed0Fu5GYMNVzaMp9u\nMWXvH0obS5nTMTPCPNiK/65naqUhdu3BQgL1bbFduWzYkzsVzuNgJygL0fIWIt+B\n3GrnTxfzAgMBAAECggEABhFAZEwAgXDqeNj23+TDsgtSjbpyk6j+uX6Gk0EfDElE\n+Q86ArBaqeBcr+m8+lMSg7nsZwr23ksIqpzxxvj9wTdceI7alfaN0rUpVId60Q4d\nqnXYKBtaFSwhPqddsCLuN5BKQrwcoPEa5g/m60puEYUhzFe6md2CPwrmdk9IZWwe\nRzxkoovhG8KHOzB3B8sj/ojlxMLtzW4NiSpGMBzdn/k5Hk7AwMbeqWTg4TXgWnQM\nTAiWLo978gTVfoAg2U7T/N5mH7H3ll063VLIxKDc+CDIrWnKMEU1jrzZp+tVUeEQ\nokU9QjrfCMBDh8easD5hoDXcFqKvREAcj5dr1U9oSQKBgQDdxpdopCaADJrdHiO0\nze0jahrmucvbnoKc6jQRC9W8rXmITbws1RPpf12of+9htrORDlk5DGFWmcAIebWC\nBjJsEHI4yMI+6zK0qCq/noojGHMBFBzP22lTnblbRDGHALaiq7JJ8mjjm2Lc8JFl\nvjOtuAhW83R1SeFa9UcTSzScaQKBgQDR8lfUgjAT220MtQYDJ1dQZfMZOdY7g6rQ\nnyEexjoUpd6JgO3R674uNJoKViorQTN3NZ8265iJ20Hr008u9aqItTaBWhpslqXL\nAJaMJ41FBvkol8JpmzBhxbiCpxd71I5TPdShDNbl4rz/2yZsJqwecsd8+7Qnr0UZ\nJMgZKJg1+wKBgB+AXu9ZKbLUl4bDCjVbbsyx/KI7T+6hJFJfngex06laRsIKsKj5\nlzt6gPY3Pex2RCldjWTiEk13x2QszZBriuv4phDUy2qeg/RPUssnHN4BUgycK7+G\nnf5nj/WbySExA8A1fTyttyJlZvSVI0H9c1/AnUakjC1A0kbWQkNGUnHJAoGADiI+\nf3P0QKH5CW32Zaf0XNlAMGaQYZlPmpPb6vJ1XoZ8IM2pNQSl3P51kFSUqizNhiz5\n9vyNXFqCaZnkLskjHej1Lmged0j9CFmVyQGwpQD/LRhqYimsbCifb0xIbHG20yvK\ncL0oinllN+RNBeLkm3gmredUDYfjIvoy7l6pQJkCgYEAgEzOTgehgWqzdKYSzlbI\ns6BLIs5z+MSA5bvPwt9vAelmsO4PjOL38xG12gRfF+MI1FtyHnqvySUHmyVta2hn\nUiQnGJ3l7Reqs6r38ZB7ogXbYldb0yiYQuh6/xBgiHW4mW8NMKooosB80xwSv6UR\nMqeTZghT6huLtjg6AZBSAZ4=\n-----END PRIVATE KEY-----\n";
		client_email = "firebase-adminsdk-nxcmm@aspirantesitz.iam.gserviceaccount.com";
		client_id = "112241459303605568705";
		auth_uri = "https://accounts.google.com/o/oauth2/auth";
		token_uri = "https://oauth2.googleapis.com/token";
		auth_provider_x509_cert_url = "https://www.googleapis.com/oauth2/v1/certs";
		client_x509_cert_url = "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-nxcmm%40aspirantesitz.iam.gserviceaccount.com";
		return this;
	}

	public RegistroFirebase quebec()
	{
		type = "service_account";
		project_id = "colegioquebec";
		// private_key_id = "156bd0b3e6fc3c080bdc1a1c441085bc5dfb8615";
		private_key_id = "AIzaSyD2tqpkyBVEK5JvCRS_1EifrKNgCRdTIPg";
		private_key = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCbTj8KE24pdRcN\njmdgffGdMCKeDwSC2RV/4ztx8wW+fIWm6ASPFT/GkdK0ut/slRAW05nsmBtaQbb1\nEZgvdQ19zUsju6WEBhjpjDCIlJkh2n9vRC2oY6nqtWfjdcJdatAcV09NfTWLOGr+\nL8zd8JUmndWU45/jWtPEaTWNRukUoA4cYLlwG9r8NF3jCyNBUL2isKqsKWMailra\n0lUReNWwHFal7czyveCHSV9z3eYYW5eYrvO9WBfFYm3I3DXf+UBv6/VDpKkQZuLs\nwT9sXr879ualSu92Abap0ZN6Sk2iNEB1omqRtzkNBjySGsJtmzieJ506LGb9F41L\nHL6ZiYxxAgMBAAECggEAE4QyCyZv7zPF/C/LW+aCc1oLhPNRgiPyPgpPJmhUw3Wg\nfLNRcgLzQGqDdloO2Qsjuh/zNYvT0XQf9WIK+YPAeJumIqJqZVHi1Y6GwX3IVJHB\noTjfHUxmRkFvrGItqlGe6hYquAvRAQ12RzpjM0y6tt9Ev3DEtJcYX5PyZS47t29H\ne05O4JxZZKy51JiquXK5W2rJGw5ujqcHY+b1oGgCz53mTVZuLlcrDGsqWfwnsDVh\n9my4ntkT4OV22U7wtW3KiW7KYCGetu/n2LQ8zQOxVMoiWmeB+obq5vLMZjKc+5O6\nxyzq7Qp/DxHTuu/gC/7eqdKajI7MJSQB1rz9z6/z9QKBgQDO5bEuzGpOVTkUeFUJ\nkOAti8cAYYOioeUGeLaAkAK/u14Guck2J5wyeUX4ht4KbNELaRCFcOIfr7Kp3MAy\nXWFAr0SYIV+ZLLdKS/4tL7NQ4ab3CuSVG0J7qWhE0hVQa0pbwRzISWsSGP9iiApP\nh/xPbsfTCJTsU3lB2QL0Qtq2GwKBgQDAKgp6anskMqkQPibtKZz1EVLRSV3dqCUo\nRtjmRkm7aJ0tyNRARbJNl53rPzuXcGgB8yDWpte3jfOUFzLmzs6qwtcYM6AU6wib\nj+Fvbiagzu+8ZqDHkByS3EJeWCodRvjyp5RlU85nFVJUpKX+9N1xQClpbFnbyuen\ngS6RlrFgYwKBgB6yvgNvmSZeRsXexN9Se7DGWJSZ42oyE0VOi+WveHjyWBUvY8eB\nQQ/MJrGlcTSiyLGkuSrTgPmqnBvQAUR3zoJGfysDaKfVlqyTcfdKaJTLpnZpS1lE\nXizzCeGMOlVgVfwfPyIIorZgtyPrg3whdTJkAYoyb8ZQ7GD0zhdoBAOZAoGBAI4D\nQ8UeRi0FJ34ygHAKrc1K5Sp4Dt+NsRAn84mSblEKygYZAgsRtuiy4OkGzRJo5uRx\n+lXH7WnghR9vWZXLRl5aKb3gATEUVUMpvM+t1uxGolNYgP+amBNMpdu1SkJivf4O\nLJQJsGLsFfEp0OcvrStR4IjhozLUrAhVZsX/WMzDAoGAOokBHkMnwAmAGwd7wXIs\nK8Sd3woH0xJMI1TrBKRguw5X7Q/f5HiHb/AMkh1y8e0k1y4atzJAXpGlQ9H+6M00\nH8dhchP+/vLo4CAFu2GJcr6Ia2KFCw3VuGdD9E0KTBK87mzJIsMVvaQwjyaEq4Em\nE2YkDEeRMbvB2yiNYVgfwOY=\n-----END PRIVATE KEY-----\n";
		client_email = "colegioquebec@appspot.gserviceaccount.com";
		client_id = "114951172902589567027";
		auth_uri = "https://accounts.google.com/o/oauth2/auth";
		token_uri = "https://oauth2.googleapis.com/token";
		auth_provider_x509_cert_url = "https://www.googleapis.com/oauth2/v1/certs";
		client_x509_cert_url = "https://www.googleapis.com/robot/v1/metadata/x509/colegioquebec%40appspot.gserviceaccount.com";
		return this;
	}

	public RegistroFirebase citid()
	{
		type = "service_account";
		project_id = "citiditzacatepec";
		private_key_id = "2f66eea97c103fb08efc84743ac46177e4568706";
		private_key = "-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDK5kRthcDElvqc\nbesMMX7Zci1H0WnMBog4o9Qm8vZEht0OjmdwnmPDdwsdS7ksgtTrLDwvaFEzzRjR\nRTlO6LAc5yFiasJX4ov+Rmw7lM4UUNQhvH0nKpMBrYPlUIY2MJGgb5imLo5kP/3D\ntNQNWyB5xrELiiCr0YqyH7S2qkYgD+s07/0PA/mdgVs09G/4OwcvdIi/eA9l+np7\naCKf3GNTpQvNec/LrZ2j0jJW3SgwJZiJFMwOYa35/F7JTfcjgF1Kq/1XMOt1dyyf\nOfO2aeVNIHYHC5e5hOkbmiMI4Xyf0qKW3oR65kByeQF9UP0n6o/eSy1rZ75xO5o+\n3EivjbtRAgMBAAECggEACO2n0HF4rXXu1nwcQhu59x/X9/9yMj8N1r83zlR164dL\nOjEgQmOH5JGsGKiMwBWMQMKALf5fR2Ikr83F4y/oUwdFL+9eeK9QhXqMF/WY+Woi\noY7pq3PrRuE/qvM3irIpsFeEzjhBfg4WULq385QBWnZ4szcrb6AfhC3SvhCBWDcD\nDUjMKZykuFlLjTbv4+rPuGIUT31pOSoRF7LF7/hUGvw4PiSBVyn6aSN9FGoMVkzu\n0c4/of/bYqLmnXnixFgY5inVYqOs6fjM1gE4DeZjY2/jICdhWUdNzk7Hu0GqcHXo\nsxLRh4vksJsL3SV9XzmTuA+T+5M8yQPsJDwsfls0GQKBgQDgYRO02pK0vvRkds/b\nDinY4dpo97Ro3q3kTA61LLogMFXGJAFMmX4cyoVP0cnq37sQ/JNsU00zSQcVo+U/\nmJ2lVe2/74ynUFkP7iu7+1pxv5MLqRB4l+djDpDYm37/cl//WJ0xASe5XZtC2Jfm\nsGUGJJbA9D6scw83w8oWqNKzuQKBgQDnfkRNZ+mk6yeQjqFLIGX3NywZcwlN870U\nQih+D7MVOjScJZIUX+J3jQuTVcLCP6uTY7Wyqe/zJBEU3zE8lmeHhS8EYkyL0DDN\n04EaMXYy2CwEzNTOZ1GvUZ04turJxjvGaJXkW/rkYNfMw0t9OH0e98ijFudZUaGr\nIrqD6ddAWQKBgHfAN8VBFiUy+LoZkwuFPp5Kw8db1ERX/BSo5vyYt2lwgoayNqNM\nFDuHdqjH/WzGJU+GjaO1vbEOW6KYC0TqzdAs0SurzLSLNE1FPsAgAQBOT0tc2raR\n0+NRJcsFCj2JLGTaRWKfDDVpGPEPKdrr767cnjyy3jQpYEjRzKxVQ8a5AoGBAKf0\nf5/dnbIO/yStpy63seM8f11zjjOlfPC+01wrDdZ/5X3I8ISh0NDGX7ilB2oiAd0t\nAb4/95zj9RS8np+DzFeR9LvsifcCtPYQ12Fms4hOORm+d0PNyIE36KcmZ5C/p8zb\nQq1tYsnhzZB9vT58BqO6STKywmWWiYJ97u8YcRj5AoGAOiSnKu+CjYHXDBCw3mm+\n5BCb5XPsgHBcmtW5L23rqxVv1Ciy0ruglYC3u7IPz94ppAXLLbzVG1Shp4uPOo/1\n7DuWFHitbhb3INGO+DXb3lm2WD/HOKJyx88dfuOc21TnXFpzkKob4n6j2UsDxruq\nnegF9O2qBtJOuXDC53HpJJM=\n-----END PRIVATE KEY-----\n";
		client_email = "citiditzacatepec@appspot.gserviceaccount.com";
		client_id = "110385124488450870175";
		auth_uri = "https://accounts.google.com/o/oauth2/auth";
		token_uri = "https://oauth2.googleapis.com/token";
		auth_provider_x509_cert_url = "https://www.googleapis.com/oauth2/v1/certs";
		client_x509_cert_url = "https://www.googleapis.com/robot/v1/metadata/x509/citiditzacatepec%40appspot.gserviceaccount.com";
		return this;
	}

	public RegistroFirebase aspirantespapaloapan()
	{
		{
			type = "service_account";
			project_id = "ingresopapaloapan";
			private_key_id = "217ada3a88e10c8e50722690553c66bb128f561d";
			private_key = "-----BEGIN PRIVATE KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDqpJw1y/TUZ9E6\nsQHb3+EVpKKWxIpqwaHzbo/VsRX4aJw5SuBQrmV18loDw8XUK6dIe0lekq/8vIee\nslp+bPZDA+nDppOKBu8GiiAHBN04aNcD2WvyKnX9qlQS4omQqPYiUIf+HEcd3d1M\n8LsmnWedO2xcVnh6Pl8+dqYbKzusdqFk0AQXs+YuZB4jXUyFXIwYtGec9gboWhW9\ntXZQVedw2JHBSBqU4UetoNaiV28oSiMlmXZIgGcav941Y1oqCSRH/MZzeN/HKoT2\nCpRLcjPGrmk4wmBK14lFO7B/vBipRkfuAMP4wC+oEzS7XEYBzaOk+G94y1yGJGH4\nX1YB/aFFAgMBAAECggEAEhC75Slvj2Xx1jS4GateO0oaaYS2ynrfguxFfzSb5iz5\nsDCLXjLbJW5UD1ukkM4OmlZBoxokmg8S2v1M2dR+TlEQD6v0yoj3oLeEOT4e4R+z\nRDzaYoHx5SaWxAB0inJzxtcP7VjUgeBp0Clto061okWntWFD89d3Akpkxg05UjEH\nRAQS5sZRJttP63W2ymNJR75jAqeWp2Mg621W7fHN5m4PmbepzJ6prbDNjTLoxZui\nLNy8hmo1LECyayE1LMqVJXG7xDCdaehD6a5gVknlMgek6fNKvDladh/sYuk8ukOg\nwrbiCqr/7cMJlIoUS/B71DZDLRSapp5dx7SMR5pDaQKBgQD43t79wVTkIvzlNyFf\n9EIfiZiMTDmHbSD8icORFvLAi6ESidlorMvZzW5T+INptHyK9DinhBQiHEhwxt4M\n7JSrLcXDsYaZspUytPXjYRn21BXt5JNCB38Ne5U/TGzkCp/XAjIA4hGJlxnhe/93\n3D/ld7qtGnjj9CMe5XLBo8oqPQKBgQDxXWYqR1ed8l3vtb/wQ+4iyaZAQIiuXMep\nvwyaNai38yIPPcLQYmjZWq/kPalan8h7L1cscXVIiOsYqTpwNbEn/LsXNT/bLdPz\neEeDw8/PdrHAQuKppWaUJFigKi7xeIrQcG+1Uu3I0dkAd9yD+FV52eCz7e2fNP4i\nW8BZ9qWrqQKBgGQ0uOzLr3a8b7+LVzDflNBGAtpaxr80vZdxkQEWkF/e2NgyEQwI\np3vnL4k4AxHIzmzUsQsiL0kcwj5GlJn3mFTkdUC6dkvkkBZ+rpMDQgUUmE/VPUXU\n5t9y50E5cI7RiFJ2W9PnMtCHurAD0XVdhYzLjKqugganAo0qLe6yGHCxAoGAZP7f\nBCvsFrRW6DoWAZR7LeVRAqu+Ra+fAIFn5ZM0cRx0kQoX3ZiAJQsUdJ30om4ftqP9\nhyRGnj5kmWIeiNt+sKvJIZHvkWggu00GJ7Wk3DvfbwLN04zZWn3G8+YS1InLFCMo\nKyhzRUfB1LdS94nPQniP1NpnRuomuPvJhht2AVkCgYAPAy4qeVdAxwSa3/guCqPf\nDWTFm7QHVjgFitU77rLDyko37U9MdhMLvMke/yvWVOLjZMUrI1yXO4evLq3f/5/z\n/RRZZKguRWMcwny5TuZWHqTRZHmKKUnF6gRi5RyGVK1r9ZR90vKLeCqO+z2n9kSn\nBaeTrrlsNd9ICo/Sp4NkJQ==\n-----END PRIVATE KEY-----\n";
			client_email = "firebase-adminsdk-fbsvc@ingresopapaloapan.iam.gserviceaccount.com";
			client_id = "103995877109195318523";
			auth_uri = "https://accounts.google.com/o/oauth2/auth";
			token_uri = "https://oauth2.googleapis.com/token";
			auth_provider_x509_cert_url = "https://www.googleapis.com/oauth2/v1/certs";
			client_x509_cert_url = "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-fbsvc%40ingresopapaloapan.iam.gserviceaccount.com";
			return this;
		}
	}

}
